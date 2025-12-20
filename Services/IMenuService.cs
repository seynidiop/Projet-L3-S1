using Projet_L3_S1.Models;

namespace Projet_L3_S1.Services
{
    public interface IMenuService
    {
        IEnumerable<menu> GetAll(int page = 1);
        int Count(int page = 1);
        menu? GetById(int id);
    }
}
