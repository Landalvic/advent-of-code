import React, { Component } from "react";
import { Route, Switch, withRouter } from "react-router-dom";
import { MuiThemeProvider, createMuiTheme, withStyles } from "@material-ui/core";
import Waiting from "structure/Waiting";
import Erreur from "structure/Erreur";
import Snack from "structure/Snack";
import Header from "structure/Header";
import Accueil from "components/Accueil";
import Jours from "exercices/Jours";

const defaultTheme = createMuiTheme({
  overrides: {
    MuiTableCell: {
      head: {
        fontWeight: "bold"
      }
    }
  },
  typography: {
    useNextVariants: true
  }
});

class App extends Component {
  componentDidMount() {
    document.title = "Advent of code";
  }

  render() {
    const { classes } = this.props;
    return (
      <MuiThemeProvider theme={defaultTheme}>
        <div className={classes.root}>
          <Erreur />
          <Waiting />
          <Snack />
          <Header />
          <Switch>
            <Route path="/annee/:annee/jour/:jour" component={Jours} />
            <Route path="" component={Accueil} />
          </Switch>
        </div>
      </MuiThemeProvider>
    );
  }
}

const styles = {
  root: {
    textAlign: "center",
    margin: 0,
    overflowX: "hidden"
  }
};

export default withStyles(styles)(withRouter(App));
