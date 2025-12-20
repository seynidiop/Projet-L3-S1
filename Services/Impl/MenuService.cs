using Microsoft.EntityFrameworkCore;
using Projet_L3_S1.Data;
using Projet_L3_S1.Models;

namespace Projet_L3_S1.Services.Impl
{
    public class MenuService : IMenuService
    {
        private readonly ProjetL3S1DbContext _context;
        

        private const int size = 4;

        public MenuService(
            ProjetL3S1DbContext context)
        {
            _context = context;
           
        }

        public IEnumerable<menu> GetAll(int page = 1)
        {
            if (page < 1) page = 1;

            int offset = (page - 1) * size;

            return _context.menu
                .Where(b => b.archived == false)
                .Include(m => m.burger)
                .Include(m => m.complement)
                .Skip(offset)
                .Take(size)
                .ToList();
        }

        public int Count(int page = 1)
        {
          
                return _context.menu
                    .Count(m => m.archived == false || m.archived == null);
           
        }

        public menu? GetById(int id)
        {
        
                return _context.menu
                    .Include(m => m.burger)
                    .Include(m => m.complement)
                    .FirstOrDefault(m => m.id == id);
            
           
        }
    }
}
