const initialState = {
  waiting: 0,
  context: "/advent-of-code",
  erreurs: [],
  profil: null,
  snack: ""
};

export const generalReducer = (state = initialState, action) => {
  switch (action.type) {
    case "WAITING_TRUE": {
      return Object.assign({}, state, {
        waiting: state.waiting + 1
      });
    }
    case "WAITING_FALSE": {
      return Object.assign({}, state, {
        waiting: state.waiting - 1
      });
    }
    case "ADD_ERREUR": {
      const newErreurs = state.erreurs.slice();
      newErreurs.push({ error: String(action.error), log: action.log });
      return Object.assign({}, state, {
        erreurs: newErreurs
      });
    }
    case "CLEAR_ERREUR": {
      return Object.assign({}, state, {
        erreurs: []
      });
    }
    case "SET_PROFIL": {
      return Object.assign({}, state, { profil: action.profil });
    }
    case "SET_SNACK": {
      return Object.assign({}, state, { snack: action.snack });
    }
    default:
      return state;
  }
};

export const setSnack = snack => {
  return { type: "SET_SNACK", snack };
};

export const setProfil = profil => {
  return { type: "SET_PROFIL", profil };
};

export const waitingTrue = () => {
  return { type: "WAITING_TRUE" };
};

export const waitingFalse = () => {
  return { type: "WAITING_FALSE" };
};

export const clearErreur = () => {
  return {
    type: "CLEAR_ERREUR"
  };
};

export const addErreur = (error, log) => {
  return {
    type: "ADD_ERREUR",
    error,
    log
  };
};
