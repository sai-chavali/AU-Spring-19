import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import IconButton from '@material-ui/core/IconButton';
import Tooltip from '@material-ui/core/Tooltip';
import ChevronLeftIcon from '@material-ui/icons/ChevronLeft';
import Paper from '@material-ui/core/Paper';

const styles = theme => ({
  root: {
    width: '90%',
    marginLeft: '8%',
    marginTop: '8%',
    overflowX: 'auto',
  },
  table: {
    minWidth: 700,
  },
});

function ccyFormat(num) {
  return `${num.toFixed(2)}`;
}

// function priceRow(qty, unit) {
//   return qty * unit;
// }

function subtotal(items) {
  return items.map(({ price }) => price).reduce((sum, i) => sum + i, 0);
}

function SpanningTable(props) {
  const { classes, data, selected_indexes, func } = props;

  const subtotalparameter = () => {
    let li = []
    selected_indexes.map((id) => li.push({ price: data[id - 1].price }));
    return li
  }

  return (
    <Paper className={classes.root}>
      <Tooltip title="Back">
        <IconButton aria-label="Back" onClick={func}>
          <ChevronLeftIcon />
        </IconButton>
      </Tooltip>
      <Table className={classes.table}>
        <TableHead>
          <TableRow>
            <TableCell>Item</TableCell>
            <TableCell>Qty.</TableCell>
            <TableCell>Price</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {selected_indexes.map(row => {
            return (
              <TableRow key={data[row - 1].id}>
                <TableCell>{data[row - 1].item}</TableCell>
                <TableCell>{data[row - 1].qty}</TableCell>
                <TableCell>{ccyFormat(data[row - 1].price)}</TableCell>
              </TableRow>
            );
          })}
          <TableRow>
            <TableCell align="right">Total</TableCell>
            <TableCell colSpan={1}></TableCell>
            <TableCell align="left">{ccyFormat(subtotal(subtotalparameter()))}</TableCell>
          </TableRow>
        </TableBody>
      </Table>
    </Paper>
  );
}

SpanningTable.propTypes = {
  classes: PropTypes.object.isRequired,
  data: PropTypes.array.isRequired,
  selected_indexes: PropTypes.array.isRequired,
};

export default withStyles(styles)(SpanningTable);