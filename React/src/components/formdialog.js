import React from 'react';
import PropTypes from 'prop-types';
import Button from '@material-ui/core/Button';
import TextField from '@material-ui/core/TextField';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import { withStyles } from '@material-ui/core/styles';
import DialogTitle from '@material-ui/core/DialogTitle';
import Fab from '@material-ui/core/Fab';
import AddIcon from '@material-ui/icons/Add';

const styles = theme =>({
  textField: {
    marginLeft: theme.spacing.unit,
    marginRight: theme.spacing.unit,
    width: 200,
  },
})

class FormDialog extends React.Component {
  state = {
    open: false,
    item:'',
    price:'',
    qty:''
  };

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value,
    });
  };

  handleClickOpen = () => {
    this.setState({ open: true });
  };

  handleClose = () => {
    this.setState({ open: false });
  };

  render() {
    const {func} = this.props;
    
    return (
      <div>
        <Fab color="primary" aria-label="Add" onClick={this.handleClickOpen}>
          <AddIcon />
        </Fab>
        <Dialog
          open={this.state.open}
          onClose={this.handleClose}
          aria-labelledby="form-dialog-title"
        >
          <DialogTitle id="form-dialog-title">Add Item</DialogTitle>
          <DialogContent>
            <TextField
              label="Item Name"
              name='item'
              value={this.state.item}
              onChange={this.handleChange}
              type="text"
            />
            <TextField
              label="Price"
              name='price'
              value={this.state.price}
              onChange={this.handleChange}
              type="Number"
            />
            <TextField
              label="Quantity"
              name='qty'
              value={this.state.qty}
              onChange={this.handleChange}
              type="Number"
            />
          </DialogContent>
          <DialogActions>
            <Button onClick={this.handleClose} color="primary">
              Cancel
            </Button>
            <Button onClick={() => {func(this.state.item, Number(this.state.price),Number(this.state.qty));this.handleClose()}} color="primary">
              Add
            </Button>
          </DialogActions>
        </Dialog>
      </div>
    );
  }
}

FormDialog.propTypes = {
  func:PropTypes.func,
};

export default withStyles(styles)(FormDialog);