using System;
using System.Collections.Generic;

namespace Projet_L3_S1.Models;

public partial class commande
{
    public int id { get; set; }

    public int? clientid { get; set; }

    public int? menuid { get; set; }

    public int? burgerid { get; set; }

    public int? complementid { get; set; }

    public DateTime? datecommande { get; set; }

    public string? statut { get; set; }

    public string? modepaiement { get; set; }

    public bool? archived { get; set; }

    public string? typecons { get; set; }

    public double? montanttotal { get; set; }

    public virtual burger? burger { get; set; }

    public virtual client? client { get; set; }

    public virtual complement? complement { get; set; }

    public virtual menu? menu { get; set; }
}
