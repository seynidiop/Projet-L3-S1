using System;
using System.Collections.Generic;

namespace Projet_L3_S1.Models;

public partial class menu
{
    public int id { get; set; }

    public string? nom { get; set; }

    public string? description { get; set; }

    public int? burgerid { get; set; }

    public int? complementid { get; set; }

    public double? price { get; set; }

    public string? imagepath { get; set; }

    public bool? archived { get; set; }

    public virtual burger? burger { get; set; }

    public virtual ICollection<commande> commande { get; set; } = new List<commande>();

    public virtual complement? complement { get; set; }
}
