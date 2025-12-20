using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
using Projet_L3_S1.Models;

namespace Projet_L3_S1.Data;

public partial class ProjetL3S1DbContext : DbContext
{
    public ProjetL3S1DbContext()
    {
    }

    public ProjetL3S1DbContext(DbContextOptions<ProjetL3S1DbContext> options)
        : base(options)
    {
    }

    public virtual DbSet<burger> burger { get; set; }

    public virtual DbSet<client> client { get; set; }

    public virtual DbSet<commande> commande { get; set; }

    public virtual DbSet<complement> complement { get; set; }

    public virtual DbSet<menu> menu { get; set; }

    public virtual DbSet<quartier> quartier { get; set; }

    public virtual DbSet<zone> zone { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see https://go.microsoft.com/fwlink/?LinkId=723263.
        => optionsBuilder.UseNpgsql("Host=ep-silent-sky-a4pcdzks-pooler.us-east-1.aws.neon.tech;Database=brasilBurger;Username=neondb_owner;Password=npg_84wkyrJmIczi;SSL Mode=Require;Trust Server Certificate=true");

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<burger>(entity =>
        {
            entity.HasKey(e => e.id).HasName("burger_pkey");

            entity.HasIndex(e => e.name, "burger_name_key").IsUnique();

            entity.Property(e => e.id).UseIdentityAlwaysColumn();
            entity.Property(e => e.archived).HasDefaultValue(false);
            entity.Property(e => e.imagepath).HasColumnType("character varying");
            entity.Property(e => e.name).HasColumnType("character varying");
        });

        modelBuilder.Entity<client>(entity =>
        {
            entity.HasKey(e => e.id).HasName("client_pkey");

            entity.Property(e => e.id).UseIdentityAlwaysColumn();
            entity.Property(e => e.email).HasColumnType("character varying");
            entity.Property(e => e.firstname).HasColumnType("character varying");
            entity.Property(e => e.lastname).HasColumnType("character varying");
            entity.Property(e => e.passwordhash).HasColumnType("character varying");
            entity.Property(e => e.phone).HasColumnType("character varying");
        });

        modelBuilder.Entity<commande>(entity =>
        {
            entity.HasKey(e => e.id).HasName("commande_pkey");

            entity.Property(e => e.id).UseIdentityAlwaysColumn();
            entity.Property(e => e.datecommande).HasColumnType("timestamp without time zone");
            entity.Property(e => e.modepaiement).HasColumnType("character varying");
            entity.Property(e => e.statut).HasColumnType("character varying");
            entity.Property(e => e.typecons).HasColumnType("character varying");

            entity.HasOne(d => d.burger).WithMany(p => p.commande)
                .HasForeignKey(d => d.burgerid)
                .HasConstraintName("burgerfk");

            entity.HasOne(d => d.client).WithMany(p => p.commande)
                .HasForeignKey(d => d.clientid)
                .HasConstraintName("clientfk");

            entity.HasOne(d => d.complement).WithMany(p => p.commande)
                .HasForeignKey(d => d.complementid)
                .HasConstraintName("complementfk");

            entity.HasOne(d => d.menu).WithMany(p => p.commande)
                .HasForeignKey(d => d.menuid)
                .HasConstraintName("menufk");
        });

        modelBuilder.Entity<complement>(entity =>
        {
            entity.HasKey(e => e.id).HasName("complement_pkey");

            entity.HasIndex(e => e.name, "complement_name_key").IsUnique();

            entity.Property(e => e.id).UseIdentityAlwaysColumn();
            entity.Property(e => e.imagepath).HasColumnType("character varying");
            entity.Property(e => e.name).HasColumnType("character varying");
        });

        modelBuilder.Entity<menu>(entity =>
        {
            entity.HasKey(e => e.id).HasName("menu_pkey");

            entity.Property(e => e.id).UseIdentityAlwaysColumn();
            entity.Property(e => e.description).HasColumnType("character varying");
            entity.Property(e => e.imagepath).HasColumnType("character varying");
            entity.Property(e => e.nom).HasColumnType("character varying");

            entity.HasOne(d => d.burger).WithMany(p => p.menu)
                .HasForeignKey(d => d.burgerid)
                .HasConstraintName("burgerfk");

            entity.HasOne(d => d.complement).WithMany(p => p.menu)
                .HasForeignKey(d => d.complementid)
                .HasConstraintName("complementfk");
        });

        modelBuilder.Entity<quartier>(entity =>
        {
            entity.HasKey(e => e.id).HasName("quartier_pkey");

            entity.Property(e => e.id).UseIdentityAlwaysColumn();
            entity.Property(e => e.nom).HasColumnType("character varying");

            entity.HasOne(d => d.zone).WithMany(p => p.quartier)
                .HasForeignKey(d => d.zoneid)
                .HasConstraintName("zonefk");
        });

        modelBuilder.Entity<zone>(entity =>
        {
            entity.HasKey(e => e.id).HasName("zone_pkey");

            entity.Property(e => e.id).UseIdentityAlwaysColumn();
            entity.Property(e => e.nom).HasColumnType("character varying");
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
