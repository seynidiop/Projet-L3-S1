using System;
using System.Collections.Generic;

namespace Projet_L3_S1.Models;

public partial class quartier
{
    public int id { get; set; }

    public string? nom { get; set; }

    public int? zoneid { get; set; }

    public virtual zone? zone { get; set; }
}
