
const CART_KEY = "brasilBurger_cart";


/* Ouvrir / fermer le panier */
function toggleCart() {
    document.getElementById("cart").classList.toggle("open");
}

function clearCart() {
    localStorage.removeItem(CART_KEY);
    renderCart();
    showAlert("🧹 Panier vidé");
}

function getCart() {
    const cart = localStorage.getItem(CART_KEY);
    return cart ? JSON.parse(cart) : [];
}

function saveCart(cart) {
    localStorage.setItem(CART_KEY, JSON.stringify(cart));
}
document.addEventListener("DOMContentLoaded", () => {
    renderCart();
});

function calculateTotal(cart) {
    return cart.reduce((total, item) => total + item.price, 0);
}

/* Ajouter au panier */
function addToCart(id, name, price, image, type) {
    let cart = getCart();

    const exists = cart.find(p => p.id === id && p.type === type);
    if (exists) {
        alert("Le produit est déjà dans le panier");
        return;
    }

    cart.push({
        id,
        name,
        price,
        image,
        type
    });
    alert("✅ Produit ajouté au panier");
    saveCart(cart);
    renderCart();
    
}

/* Afficher un message d'alerte */


/* Forcer l'ouverture */
function openCart() {
    document.getElementById("cart").classList.add("open");
}

/* Supprimer un élément */
function removeFromCart(id, type) {
    let cart = getCart();
    cart = cart.filter(p => !(p.id === id && p.type === type));

    saveCart(cart);
    renderCart();
    showAlert("🗑️ Produit retiré du panier");
}

function addBurger(id) {
    fetch('/Panier/AddBurger?id=' + id, { method: 'POST' })
        .then(r => {
            if (!r.ok) throw new Error();
            showAlert("✅ Burger ajouté");
        })
        .catch(() => showAlert("⚠️ Un seul burger autorisé"));
}

/* Affichage */
function renderCart() {
    const cartItems = document.getElementById("cart-items");
    const cartTotal = document.getElementById("cart-total");
    const cart = getCart();

    cartItems.innerHTML = "";

    if (cart.length === 0) {
        cartItems.innerHTML = "<p>Panier vide</p>";
        cartTotal.innerText = "0 FCFA";
        return;
    }

    let total = 0;

    cart.forEach(p => {
        total += p.price;

        cartItems.innerHTML += `
            <div class="cart-item">
                <img src="${p.image}" width="40">
                <span>${p.name}</span>
                <strong>${p.price} FCFA</strong>
                <button onclick="removeFromCart(${p.id}, '${p.type}')">❌</button>
            </div>
        `;
    });

    cartTotal.innerText = total + " FCFA";

}

