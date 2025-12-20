namespace Projet_L3_S1.Services;
using Projet_L3_S1.Models;
public interface ICommandeService
{
    Task<IEnumerable<commande>> GetAllCommandesAsync();
    Task<commande> GetCommandeByIdAsync(int id);
    Task CreateCommandeAsync(commande cmd);
    Task UpdateStatutAsync(int id, string nouveauStatut);
}
