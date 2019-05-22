import React from "react";
import { connect } from "react-redux";
import { withStyles } from "@material-ui/core";
import loading from "structure/loading.gif";

export const Waiting = ({ waiting, classes }) => {
  if (waiting > 0) {
    return (
      <div className={classes.waitOn}>
        <img alt="Veuillez-patienter..." src={loading} />
      </div>
    );
  }
  return null;
};

const styles = {
  waitOn: {
    position: "absolute",
    width: "20%",
    height: "20%",
    top: "40%",
    left: "40%",
    backgroundColor: "white",
    opacity: 0.5,
    zIndex: 2000
  }
};

const mapStateToProps = ({ generalReducer }) => {
  return { waiting: generalReducer.waiting };
};

export default withStyles(styles)(
  connect(
    mapStateToProps,
    null
  )(Waiting)
);
