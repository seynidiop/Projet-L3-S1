using Projet_L3_S1.Models;
using Projet_L3_S1.Data;
using Projet_L3_S1.Services;
using Microsoft.EntityFrameworkCore;

namespace Projet_L3_S1.Services.Impl;
public class CommandeService : ICommandeService
{
    private readonly ProjetL3S1DbContext _context; // Remplacez par votre nom de contexte

    public CommandeService(ProjetL3S1DbContext context)
    {
        _context = context;
    }

    public async Task<IEnumerable<commande>> GetAllCommandesAsync()
    {
        return await _context.commande
            .Include(c => c.client)
            .Include(c => c.burger)
            .Include(c => c.menu)
            .OrderByDescending(c => c.datecommande)
            .ToListAsync();
    }

    public async Task CreateCommandeAsync(commande cmd)
    {
        cmd.datecommande = DateTime.Now;
        cmd.statut = "En cours";
        cmd.archived = false;
        
        // Logique de calcul simple (à affiner selon vos prix en base)
        // cmd.montanttotal = ... 

        _context.Add(cmd);
        await _context.SaveChangesAsync();
    }

    public async Task<commande> GetCommandeByIdAsync(int id)
    {
        return await _context.commande
            .Include(c => c.client)
            .FirstOrDefaultAsync(m => m.id == id);
    }

    public async Task UpdateStatutAsync(int id, string nouveauStatut)
    {
        var cmd = await _context.commande.FindAsync(id);
        if (cmd != null)
        {
            cmd.statut = nouveauStatut;
            await _context.SaveChangesAsync();
        }
    }
}


