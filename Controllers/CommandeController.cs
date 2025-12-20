using Projet_L3_S1.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Rendering;
using Projet_L3_S1.Services;
using Projet_L3_S1.Services.Impl;
using Projet_L3_S1.Data;

namespace Projet_L3_S1.Controllers;

public class CommandeController : Controller
{
    private readonly ICommandeService _commandeService;
    private readonly ProjetL3S1DbContext _context;

    public CommandeController(ICommandeService commandeService, ProjetL3S1DbContext context)
    {
        _commandeService = commandeService;
        _context = context;
    }

    // GET: Commande/Create
   // CommandeController.cs
    public IActionResult Create()
    {
        // On récupère les listes avec les prix
        ViewBag.clientid = new SelectList(_context.client, "id", "nom");
        
        // Pour les produits, on passe la liste brute pour gérer les data-attributes dans la vue
        ViewBag.burgers = _context.burger.Where(b => !b.archived).ToList();
        ViewBag.menus = _context.menu.Where(m => !m.archived).ToList();
        ViewBag.complements = _context.complement.Where(c => !c.archived).ToList();

        ViewBag.TypeCons = new List<string> { "Sur place", "A emporter", "Livraison" };
        ViewBag.ModesPaiement = new List<string> { "Espèces", "Carte Bancaire", "Mobile Money" };

        return View();
    }
    // POST: Commande/Create
    [HttpPost]
    [ValidateAntiForgeryToken]
    public async Task<IActionResult> Create(commande cmd)
    {
        if (ModelState.IsValid)
        {
            await _commandeService.CreateCommandeAsync(cmd);
            return RedirectToAction(nameof(Index));
        }
        return View(cmd);
    }

    public async Task<IActionResult> Index()
    {
        var list = await _commandeService.GetAllCommandesAsync();
        return View(list);
    }
}