import React, { Component } from "react";
import { connect } from "react-redux";
import { bindActionCreators } from "redux";
import { clearErreur, waitingFalse } from "reducers/GeneralReducer";
import { Dialog, DialogTitle, DialogActions, Button, withStyles } from "@material-ui/core";

class Erreur extends Component {
  handleClose = () => {
    const { erreurs, waitingFalse, clearErreur } = this.props;
    erreurs.forEach(() => {
      waitingFalse();
    });
    clearErreur();
  };

  render() {
    const { erreurs, classes } = this.props;
    const mapErreurs = erreurs.map(erreur => {
      switch (erreur.error) {
        case "Error: Network Error":
          return "Le serveur ne répond pas";
        case "Error: Request failed with status code 500":
          return "Il y a eu un problème avec le serveur";
        default:
          return erreur.log ? erreur.log : erreur.error;
      }
    });
    return (
      <Dialog
        className={classes.dialog}
        open={mapErreurs.length > 0}
        onClose={this.handleClose}
        aria-labelledby="alert-dialog-title"
        aria-describedby="alert-dialog-description"
      >
        <DialogTitle>{mapErreurs.length > 0 ? mapErreurs[0] : ""}</DialogTitle>
        <DialogActions>
          <Button onClick={this.handleClose} color="primary" autoFocus>
            Ok
          </Button>
        </DialogActions>
      </Dialog>
    );
  }
}

const styles = {
  dialog: {
    zIndex: 3000
  }
};

const mapStateToProps = ({ generalReducer }) => {
  return { erreurs: generalReducer.erreurs };
};

const mapDispatchToProps = dispatch => bindActionCreators({ waitingFalse, clearErreur }, dispatch);

export default withStyles(styles)(
  connect(
    mapStateToProps,
    mapDispatchToProps
  )(Erreur)
);
