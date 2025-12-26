FROM php:8.4-cli

WORKDIR /app

# Dépendances système + PostgreSQL
RUN apt-get update && apt-get install -y \
    git unzip libpq-dev \
 && docker-php-ext-install pdo pdo_pgsql

# Installer Composer
COPY --from=composer:2 /usr/bin/composer /usr/bin/composer

# Copier le projet
COPY . .

# Créer les dossiers nécessaires à Symfony
RUN mkdir -p var/cache var/log

# Installer les dépendances PHP
RUN composer install --no-dev --optimize-autoloader

# Nettoyer le cache Symfony (sans bloquer le build)
RUN php bin/console cache:clear --env=prod || true

EXPOSE 8080

# IMPORTANT : Render fournit $PORT
CMD ["sh", "-c", "php -S 0.0.0.0:$PORT -t public"]
