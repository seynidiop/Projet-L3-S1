# Image PHP 8.4 avec Apache
FROM php:8.4-apache

# Installation des dépendances système
RUN apt-get update && apt-get install -y \
    libicu-dev \
    libpq-dev \
    libzip-dev \
    zip \
    unzip \
    git \
    curl \
    && docker-php-ext-install intl pdo pdo_pgsql zip \
    && rm -rf /var/lib/apt/lists/*

# Activation de mod_rewrite
RUN a2enmod rewrite

# Configuration d'Apache pour Symfony (/public)
ENV APACHE_DOCUMENT_ROOT=/var/www/html/public

RUN sed -ri -e 's!/var/www/html!${APACHE_DOCUMENT_ROOT}!g' \
    /etc/apache2/sites-available/*.conf \
    /etc/apache2/apache2.conf

# Installation de Composer
COPY --from=composer:latest /usr/bin/composer /usr/bin/composer

# Dossier de travail
WORKDIR /var/www/html

# Copie du projet
COPY . .


# Création des dossiers Symfony + permissions
RUN mkdir -p var public \
    && chown -R www-data:www-data var public


# Installation des dépendances
RUN composer install --no-dev --optimize-autoloader --no-interaction

# Nettoyage et warmup du cache prod (OBLIGATOIRE)
RUN php bin/console cache:clear --env=prod
RUN php bin/console cache:warmup --env=prod

# Port pour Render
EXPOSE 10000
