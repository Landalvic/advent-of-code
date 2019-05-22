import React, { Component } from "react";
import { connect } from "react-redux";
import { withStyles } from "@material-ui/core";
import Partie from "exercices/Partie.js";
import { part1, part2 } from "./jour1-function.js";

class Jour1 extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  handleChange = name => event => {
    this.setState({
      [name]: event.target.value
    });
  };

  render() {
    const { input } = this.props;
    return (
      <React.Fragment>
        <Partie title="Partie 1" input={input} fonction={part1} />
        <Partie title="Partie 2" input={input} fonction={part2} />
      </React.Fragment>
    );
  }
}

const styles = {
  play: {
    margin: 15,
    padding: 20
  },
  icon: {
    marginLeft: 20
  }
};

const mapStateToProps = ({ generalReducer }) => {
  return {
    context: generalReducer.context
  };
};

export default withStyles(styles)(
  connect(
    mapStateToProps,
    null
  )(Jour1)
);
