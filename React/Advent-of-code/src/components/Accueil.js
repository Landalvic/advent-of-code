import React from "react";
import {
  ExpansionPanel,
  ExpansionPanelSummary,
  ExpansionPanelDetails,
  Typography,
  Fab,
  withStyles
} from "@material-ui/core";
import { Link } from "react-router-dom";
import { ExpandMore } from "@material-ui/icons";
import { red } from "@material-ui/core/colors";

const Accueil = ({ classes }) => {
  return (
    <div>
      <ExpansionPanel>
        <ExpansionPanelSummary className={classes.annees} expandIcon={<ExpandMore />}>
          <Typography>Année 2018</Typography>
        </ExpansionPanelSummary>
        <ExpansionPanelDetails>
          <Fab to="/annee/2018/jour/1" variant="extended" aria-label="Jour 1" component={Link}>
            Jour 1
          </Fab>
        </ExpansionPanelDetails>
      </ExpansionPanel>
      <ExpansionPanel>
        <ExpansionPanelSummary className={classes.annees} expandIcon={<ExpandMore />}>
          <Typography>Année 2015</Typography>
        </ExpansionPanelSummary>
        <ExpansionPanelDetails>
          <Typography>Année 2015</Typography>
        </ExpansionPanelDetails>
      </ExpansionPanel>
    </div>
  );
};

const styles = {
  annees: {
    backgroundColor: red[200]
  }
};

export default withStyles(styles)(Accueil);
