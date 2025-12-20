using System;
using System.Collections.Generic;

namespace Projet_L3_S1.Models;

public partial class complement
{
    public int id { get; set; }

    public string? name { get; set; }

    public double? price { get; set; }

    public string? imagepath { get; set; }

    public bool? archived { get; set; }

    public virtual ICollection<commande> commande { get; set; } = new List<commande>();

    public virtual ICollection<menu> menu { get; set; } = new List<menu>();
}
