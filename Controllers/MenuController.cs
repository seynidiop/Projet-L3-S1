using Microsoft.AspNetCore.Mvc;
using Projet_L3_S1.Services;

namespace Projet_L3_S1.Controllers
{
    public class MenuController : Controller
    {
        private readonly IMenuService _menuService;

        public MenuController(IMenuService menuService)
        {
            _menuService = menuService;
        }

        public IActionResult Index(int page = 1)
        {
            var menus = _menuService.GetAll(page);
            ViewBag.Total = _menuService.Count();
            ViewBag.Page = page;

            return View(menus);
        }

        public IActionResult Details(int id)
        {
            var menu = _menuService.GetById(id);

            if (menu == null)
                return NotFound();

            return View(menu);
        }
    }
}
