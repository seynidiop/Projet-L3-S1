using Projet_L3_S1.Data;
using Projet_L3_S1.Models;

namespace Projet_L3_S1.Services.Impl
{
    public class ComplementService : IComplementService
    {
        private readonly ProjetL3S1DbContext _context;

        private const int size = 4;

        public ComplementService(
            ProjetL3S1DbContext context
            )
        {
            _context = context;
           
        }

        public IEnumerable<complement> GetAll(int page = 1)
        {
            
            
                if (page < 1) page = 1;
                int offset = (page - 1) * size;

                return _context.complement
                    .Where(c => c.archived == false || c.archived == null)
                    .OrderByDescending(c => c.id)
                    .Skip(offset)
                    .Take(size)
                    .ToList();
            }
        public int Count()
        {
           
                return _context.complement
                    .Count(c => c.archived == false || c.archived == null);
           
        }

        public complement? GetById(int id)
        {
           
                return _context.complement
                    .FirstOrDefault(c => c.id == id);
            }
            
    }
}
