import React, { Component } from "react";
import { connect } from "react-redux";
import {
  Typography,
  AppBar,
  Toolbar,
  MenuList,
  IconButton,
  Drawer,
  MenuItem,
  ListItemIcon,
  ListItemText,
  withStyles
} from "@material-ui/core";
import { Menu, Clear, Home } from "@material-ui/icons";
import { Link } from "react-router-dom";

class Header extends Component {
  constructor(props) {
    super(props);
    this.state = {
      menuOpen: false
    };
  }

  handleChange = (event, value) => () => {
    this.setState({ [event]: value });
  };

  render() {
    const { menuOpen } = this.state;
    const { keycloak, classes } = this.props;
    return (
      <header>
        <Drawer open={menuOpen} onClose={this.handleChange("menuOpen", false)}>
          <div style={{ textAlign: "right" }}>
            <IconButton color="inherit" aria-label="Menu" onClick={this.handleChange("menuOpen", false)}>
              <Clear />
            </IconButton>
          </div>
          <MenuList>
            <MenuItem to="/accueil" component={Link} onClick={this.handleChange("menuOpen", false)}>
              <ListItemIcon>
                <Home />
              </ListItemIcon>
              <ListItemText inset primary="Accueil" />
            </MenuItem>
          </MenuList>
        </Drawer>
        <AppBar position="static">
          <Toolbar>
            <IconButton color="inherit" aria-label="Menu" onClick={this.handleChange("menuOpen", true)}>
              <Menu />
            </IconButton>
            <Typography className={classes.grow} variant="h6" color="inherit">
              Advent of Code
            </Typography>
            <Typography variant="h6" color="inherit">
              {keycloak ? keycloak.tokenParsed.name : ""}
            </Typography>
          </Toolbar>
        </AppBar>
      </header>
    );
  }
}

const styles = {
  grow: {
    flexGrow: 1
  },
  logo: { width: 30, marginRight: 10 }
};

const mapStateToProps = ({ generalReducer }) => {
  return {
    keycloak: generalReducer.keycloak
  };
};

export default withStyles(styles)(
  connect(
    mapStateToProps,
    null
  )(Header)
);
