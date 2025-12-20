using Projet_L3_S1.Models;

namespace Projet_L3_S1.Services
{
    public interface IComplementService
    {
        IEnumerable<complement> GetAll(int page = 1);
        int Count();
        complement? GetById(int id);
    }
}
