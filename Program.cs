using Projet_L3_S1.Data;
using Projet_L3_S1.Services;
using Projet_L3_S1.Services.Impl;
var builder = WebApplication.CreateBuilder(args);

builder.Services.AddDbContext<ProjetL3S1DbContext>();
builder.Services.AddScoped<IBurgerService, BurgerService>();
builder.Services.AddScoped<IComplementService, ComplementService>();

builder.Services.AddScoped<IMenuService, MenuService>();


// Add services to the container.
builder.Services.AddControllersWithViews();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Home/Error");
    // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
    app.UseHsts();
}

app.UseHttpsRedirection();
app.UseStaticFiles();

app.UseRouting();

app.UseAuthorization();

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Burger}/{action=Index}/{id?}");

app.Run();
