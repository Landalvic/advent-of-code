import { combineReducers } from "redux";
import { routerReducer } from "react-router-redux";
import { generalReducer } from "reducers/GeneralReducer";

const combinedReducer = combineReducers({ routing: routerReducer, generalReducer });

export default combinedReducer;
