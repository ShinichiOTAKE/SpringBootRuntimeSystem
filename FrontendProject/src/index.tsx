import React from "react";
import { createRoot } from "react-dom/client";
import {
  createBrowserRouter,
  RouterProvider,
  useParams,
} from "react-router-dom";
import loadable from "@loadable/component";

import { Root } from "./root";
import { NotFound } from "./notFound";

import "./style.css";

const LazyLoader = () => {
  const { screenId } = useParams();
  const Component = loadable(() => import(`./feature/${screenId}/index.tsx`), {
    resolveComponent: (components) => components.Biz
  });
  return(
    <>
      <Component />
    </>
  );
};

const router = createBrowserRouter([
  {
    path: "/",
    element: <Root />,
    errorElement: <NotFound />,
    children: [
      {
        path: "/:screenId",
        element: <LazyLoader />,
      }
    ],
  },
])

const domNode = document.getElementById("root");
if (domNode) {
  const root = createRoot(domNode);
  if (root) {
    root.render(
      <RouterProvider router={router}/>
    );
  };
}