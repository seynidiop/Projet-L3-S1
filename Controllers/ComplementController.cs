using Microsoft.AspNetCore.Mvc;
using Projet_L3_S1.Services;

namespace Projet_L3_S1.Controllers
{
    public class ComplementController : Controller
    {
        private readonly IComplementService _complementService;

        public ComplementController(IComplementService complementService)
        {
            _complementService = complementService;
        }

        public IActionResult Index(int page = 1)
        {
            var complements = _complementService.GetAll(page);
            ViewBag.Total = _complementService.Count();
            ViewBag.Page = page;

            return View(complements);
        }

        public IActionResult Details(int id)
        {
            var complement = _complementService.GetById(id);

            if (complement == null)
                return NotFound();

            return View(complement);
        }
    }
}
