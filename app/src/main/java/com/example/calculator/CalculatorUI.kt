package com.example.calculator

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.DarkGray
import com.example.calculator.ui.theme.DarkGray2
import com.example.calculator.ui.theme.DarkRed
import com.example.calculator.ui.theme.Gray
import com.example.calculator.ui.theme.MediumGray
import com.example.calculator.ui.theme.Orange
import com.example.calculator.ui.theme.PrussianBlue
import com.example.calculator.ui.theme.Purple40
import com.example.calculator.ui.theme.Purple80

@Composable
fun CalculatorUI(
    viewModel: CalculatorViewModel,
){
    val expression = viewModel.expression
    val buttonSpacing = 18.dp


    Log.d("MainActivity", "onCreate: ${viewModel.expression.value}")
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkGray)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Purple80) // Background color
            ) {
                LazyRow(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth(),
                    reverseLayout = true
                ) {
                    item {
                        Box(
                            modifier = Modifier
                                .padding(vertical = 50.dp, horizontal = 16.dp)
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = expression.value,
                                textAlign = TextAlign.End,
                                modifier = Modifier
                                    .fillMaxWidth(),
                                fontWeight = FontWeight.Medium,
                                fontSize = 80.sp,
                                color = Color.Black,
                                maxLines = 1
                            )
                        }
                    }
                }
            }




            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 37.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "AC",
                    color = DarkRed,
                    modifier = Modifier
                        //add text black
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.clear()
                        }
                )

                CalculatorButton(
                    symbol = "(",
                    color = DarkGray2,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("(")
                        }
                )
                CalculatorButton(
                    symbol = ")",
                    color = DarkGray2,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append(")")
                        }
                )

                CalculatorButton(
                    symbol = "√",
                    color = DarkGray2,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.sqrt()
                        }
                )
            }
            // Scientific buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 37.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "ln",
                    color = DarkGray2,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.ln()
                        }
                )
                CalculatorButton(
                    symbol = "exp",
                    color = DarkGray2,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.exp()
                        }
                )
                CalculatorButton(
                    symbol = "log",
                    color = DarkGray2,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.log()
                        }
                )
                CalculatorButton(
                    symbol = "%",
                    color = DarkGray2,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.modulo()
                        }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 37.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "sin",
                    color = DarkGray2,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.sin()
                        }
                )
                CalculatorButton(
                    symbol = "cos",
                    color = DarkGray2,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.cos()
                        }
                )
                CalculatorButton(
                    symbol = "tan",
                    color = DarkGray2,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.tan()
                        }
                )
                CalculatorButton(
                    symbol = "÷",
                    color = DarkGray2,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("÷")
                        }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 37.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "7",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("7")
                        }
                )
                CalculatorButton(
                    symbol = "8",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("8")
                        }
                )
                CalculatorButton(
                    symbol = "9",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("9")
                        }
                )
                CalculatorButton(
                    symbol = "×",
                    color = Orange,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("×")
                        }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 37.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "4",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("4")
                        }
                )
                CalculatorButton(
                    symbol = "5",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("5")
                        }
                )
                CalculatorButton(
                    symbol = "6",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("6")
                        }
                )
                CalculatorButton(
                    symbol = "-",
                    color = Orange,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("-")
                        }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 37.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "1",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("1")
                        }
                )
                CalculatorButton(
                    symbol = "2",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)

                        .clickable {
                            viewModel.append("2")
                        }
                )
                CalculatorButton(
                    symbol = "3",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("3")
                        }
                )
                CalculatorButton(
                    symbol = "+",
                    color = Orange,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append("+")
                        }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 37.dp,end = 37.dp,bottom = 37.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "0",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f) //used to set the weight of the button
                        .clickable {
                            viewModel.append("0")
                        }
                )
                CalculatorButton(
                    symbol = ".",
                    color = MediumGray,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.append(".")
                        }
                )
                CalculatorButton(
                    symbol = "Del",
                    color = DarkRed,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.delete()
                        }
                )
                CalculatorButton(
                    symbol = "=",
                    color = Orange,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .weight(1f)
                        .clickable {
                            viewModel.evaluate()
                        }
                )
            }
        }
    }
}




