# Use an official Node.js image as the base image
FROM node:14 AS build

# Set the working directory in the container
WORKDIR /app

# Copy package.json and package-lock.json to the container
COPY package*.json ./

# Install project dependencies
RUN npm install

# Copy the entire application to the container
COPY . .

# Build the Angular application
RUN npm run build --prod

# Use a lightweight web server image as the final stage
FROM nginx:stable

# Copy the built artifacts from the builder stage to the web server image
COPY --from=build /app/dist/tierlist-frontendapp /usr/share/nginx/html

# Expose port 80
EXPOSE 80

# Start the web server
CMD ["nginx", "-g", "daemon off;"]
