using Microsoft.AspNetCore.Mvc;
using Projet_L3_S1.Services;
using Projet_L3_S1.Models;

namespace Projet_L3_S1.Controllers
{
    public class BurgerController : Controller
    {
        private readonly IBurgerService _burgerService;

        public BurgerController(IBurgerService burgerService)
        {
            _burgerService = burgerService;
        }

        public IActionResult Index(int page = 1)
        {
            var burgers = _burgerService.GetAll(page);
            ViewBag.Total = _burgerService.Count();
            ViewBag.Page = page;

            return View(burgers);
        }
    }
}
