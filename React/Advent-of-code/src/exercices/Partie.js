import React, { Component } from "react";
import { Grid, Card, CardContent, CardHeader, IconButton, withStyles } from "@material-ui/core";
import { PlayArrow } from "@material-ui/icons";

class Partie extends Component {
  constructor(props) {
    super(props);
    this.state = { resultat: "", timeResultat: "" };
  }

  handleChange = name => event => {
    this.setState({
      [name]: event.target.value
    });
  };

  handleClickPlay = () => {
    const { input, fonction } = this.props;
    const start = Date.now();
    const resultat = fonction(input);
    const millis = Date.now() - start;
    this.setState({
      resultat,
      timeResultat: millis
    });
  };

  render() {
    const { resultat, timeResultat } = this.state;
    const { classes, title } = this.props;
    return (
      <Grid item xs={6}>
        <Card className={classes.play}>
          <CardHeader
            title={title}
            action={
              <React.Fragment>
                {timeResultat}
                <IconButton className={classes.icon} onClick={this.handleClickPlay}>
                  <PlayArrow />
                </IconButton>
              </React.Fragment>
            }
          />
          <CardContent>{`${resultat}`}</CardContent>
        </Card>
      </Grid>
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

export default withStyles(styles)(Partie);
