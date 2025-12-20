using System;
using System.Collections.Generic;

namespace Projet_L3_S1.Models;

public partial class zone
{
    public int id { get; set; }

    public string? nom { get; set; }

    public double? prixlivraison { get; set; }

    public virtual ICollection<quartier> quartier { get; set; } = new List<quartier>();
}
