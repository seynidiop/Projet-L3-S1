using Projet_L3_S1.Models;

namespace Projet_L3_S1.Services
{
    public interface IBurgerService
    {
        IEnumerable<burger> GetAll(int page = 1);
        int Count();
    }
}
