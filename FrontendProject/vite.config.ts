import react from "@vitejs/plugin-react";
import { defineConfig } from "vite";

export default defineConfig({
  root: "./",
  build: {
    outDir: "./dist",
    emptyOutDir: true,
    sourcemap: true,
  },
  plugins: [
    react(),
  ],
});