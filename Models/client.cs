using System;
using System.Collections.Generic;

namespace Projet_L3_S1.Models;

public partial class client
{
    public int id { get; set; }

    public string? firstname { get; set; }

    public string? lastname { get; set; }

    public string? email { get; set; }

    public string? phone { get; set; }

    public string? passwordhash { get; set; }

    public virtual ICollection<commande> commande { get; set; } = new List<commande>();
}
