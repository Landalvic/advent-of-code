import thunkMiddleware from "redux-thunk";
import { applyMiddleware, createStore } from "redux";
import { composeWithDevTools } from "redux-devtools-extension";
import { BrowserRouter } from "react-router-dom";
import ReactDOM from "react-dom";
import React from "react";
import { Provider } from "react-redux";
import { CookiesProvider } from "react-cookie";
import combinedReducer from "reducers/combined-reducer";
import App from "App";

const store = createStore(combinedReducer, composeWithDevTools(applyMiddleware(thunkMiddleware)));

ReactDOM.render(
  <Provider store={store}>
    <BrowserRouter>
      <CookiesProvider>
        <App />
      </CookiesProvider>
    </BrowserRouter>
  </Provider>,
  document.getElementById("root")
);
