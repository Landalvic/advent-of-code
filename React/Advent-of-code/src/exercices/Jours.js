import React, { Component } from "react";
import { connect } from "react-redux";
import { TextField, Grid, withStyles } from "@material-ui/core";
import { Route, Switch } from "react-router-dom";
import Jour1 from "exercices/2018/Jour1";

class Jours extends Component {
  constructor(props) {
    super(props);
    this.state = { input: "" };
  }

  handleChange = name => event => {
    this.setState({
      [name]: event.target.value
    });
  };

  render() {
    const { input } = this.state;
    const { classes } = this.props;
    return (
      <div>
        <div>
          <TextField
            label="Input"
            multiline
            rows="4"
            value={input}
            onChange={this.handleChange("input")}
            margin="normal"
            variant="outlined"
          />
        </div>
        <Grid container>
          <Switch>
            <Route path="/annee/2018/jour/1" component={props => <Jour1 input={input} {...props} />} />
          </Switch>
        </Grid>
      </div>
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
  )(Jours)
);
