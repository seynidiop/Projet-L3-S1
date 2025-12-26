# Image PHP 8.4 avec Apache
FROM php:8.4-apache

# Installation des extensions pour PostgreSQL et Symfony
RUN apt-get update && apt-get install -y \
    libicu-dev libpq-dev libzip-dev zip unzip git \
    && docker-php-ext-install intl pdo pdo_pgsql zip

# Configuration d'Apache pour pointer vers /public
ENV APACHE_DOCUMENT_ROOT /var/www/html/public
RUN sed -ri -e 's!/var/www/html!${APACHE_DOCUMENT_ROOT}!g' /etc/apache2/sites-available/000-default.conf
RUN a2enmod rewrite

# Installation de Composer
COPY --from=composer:latest /usr/bin/composer /usr/bin/composer

# Copie du code
WORKDIR /var/www/html
COPY . .

# Installation des dépendances sans les scripts (pour éviter les erreurs de build)
RUN composer install --no-dev --optimize-autoloader --no-scripts --ignore-platform-reqs

# Droits sur les dossiers de cache

