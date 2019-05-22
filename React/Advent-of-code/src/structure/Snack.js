import React, { Component } from "react";
import { connect } from "react-redux";
import { Snackbar } from "@material-ui/core";
import { setSnack } from "reducers/GeneralReducer";
import { bindActionCreators } from "redux";

class Snack extends Component {
  handleClose = () => {
    const { setSnack } = this.props;
    setSnack("");
  };

  render() {
    const { snack } = this.props;
    return (
      <Snackbar
        anchorOrigin={{ vertical: "top", horizontal: "center" }}
        open={!!snack}
        onClose={this.handleClose}
        ContentProps={{
          "aria-describedby": "message-id"
        }}
        message={<span id="message-id">{snack}</span>}
      />
    );
  }
}

const mapStateToProps = ({ generalReducer }) => {
  return { snack: generalReducer.snack };
};

const mapDispatchToProps = dispatch => bindActionCreators({ setSnack }, dispatch);

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(Snack);
