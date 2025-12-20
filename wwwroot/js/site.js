
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
        showAlert("⚠️ Ce produit est déjà dans le panier !");
        return;
    }

    cart.push({
        id,
        name,
        price,
        image,
        type
    });

    saveCart(cart);
    renderCart();
    showAlert("✅ Produit ajouté au panier");
}

/* Afficher un message d'alerte */
function showAlert(message) {
    const alert = document.getElementById("alert");
    alert.innerHTML = message;
    alert.classList.add("show");
    setTimeout(() => {
        alert.classList.remove("show");
    }, 2000);
}

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

