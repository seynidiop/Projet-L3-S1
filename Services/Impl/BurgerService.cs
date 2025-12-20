using Projet_L3_S1.Data;
using Projet_L3_S1.Models;

namespace Projet_L3_S1.Services.Impl
{
    public class BurgerService : IBurgerService
    {
        private readonly ProjetL3S1DbContext _context;
        private const int size = 5;

        public BurgerService(ProjetL3S1DbContext context)
        {
            _context = context;
        }

        public IEnumerable<burger> GetAll(int page = 1)
        {
            if (page < 1) page = 1;

            int offset = (page - 1) * size;

            return _context.burger
                .Where(b => b.archived == false)
                .OrderByDescending(b => b.id)
                .Skip(offset)
                .Take(size)
                .ToList();
        }

        public int Count()
        {
            return _context.burger.Count(b => b.archived == false);
        }
    }
}
