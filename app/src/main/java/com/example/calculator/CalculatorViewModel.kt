package com.example.calculator

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.text.DecimalFormat
import kotlin.math.*

class CalculatorViewModel : ViewModel() {
    val expression = mutableStateOf("")

    fun clear() {
        expression.value = ""
    }

    fun sin() {
        appendScientificFunction("sin(")
    }

    fun cos() {
        appendScientificFunction("cos(")
    }

    fun tan() {
        appendScientificFunction("tan(")
    }

    fun sqrt() {
        appendScientificFunction("√(")
    }

    fun ln() {
        appendScientificFunction("ln(")
    }

    fun exp() {
        appendScientificFunction("exp(")
    }

    fun log() {
        appendScientificFunction("log(")
    }

    fun modulo() {
        appendScientificFunction("%")
    }




    private fun appendScientificFunction(func: String) {
        if (expression.value.isNotEmpty() && func != "%") {
            val lastChar = expression.value.last()
            if (lastChar.isDigit() || lastChar == ')') {
                expression.value += "×$func"
            } else {
                expression.value += func
            }
        } else {
            expression.value += func
        }
    }

    // Append a character to the expression
    fun append(char: String) {
        Log.d("append", "$char Expression Value:${expression.value}")
        if (char in "0123456789") {
            expression.value += char
        } else if (char in "+-×÷") {
            if (expression.value.isNotEmpty()) {
                val lastChar = expression.value.last()
                // if last char is an operator, replace it with the new operator
                if (lastChar in "+-×÷") {
                    expression.value = expression.value.dropLast(1)
                }
            }
            expression.value += char
        } else if (char == ".") {
            if (expression.value.isNotEmpty()) {
                val lastChar = expression.value.last()
                if (lastChar != '.') {
                    // if last char is an operator, and the current char is a dot, add a zero before the dot
                    if (lastChar in "+-×÷") {
                        expression.value += "0"
                    }
                    expression.value += char
                }
            }
        } else if (char == "(") {
            if (expression.value.isNotEmpty()) {
                val lastChar = expression.value.last()
                // if last char is not an operator, add a multiplication operator before the parenthesis
                if (lastChar !in "+-×÷") {
                    expression.value += "×"
                }
            }
            expression.value += char
        } else if (char == ")") {
            expression.value += char
        }
    }

    fun delete() {
        if (expression.value.isNotEmpty()) {
            expression.value = expression.value.dropLast(1)
        }
    }

    fun evaluate() {
        expression.value = try {
            var result = expression.value

            // Handle the scientific functions
            result = handleScientificFunctions(result, "sin", Math::sin)
            result = handleScientificFunctions(result, "cos", Math::cos)
            result = handleScientificFunctions(result, "tan", Math::tan)
            result = handleSquareRoot(result)
            result = handleScientificFunctions2(result, "ln") { ln(it) }
            result = handleScientificFunctions2(result, "exp") { exp(it) }
            result = handleScientificFunctions2(result, "log") { log10(it) }

            // Handle the modulo operator
            result = handleModulo(result)

            // Evaluate the expression
            result = evaluate(result).toString()

            // Format the result with scientific notation if necessary
            val maxDigits = 10 // Set the maximum number of digits
            val maxDecimalDigits = 6 // Set the maximum number of digits after the decimal point
            val number = result.toDoubleOrNull()
            if (number != null) {
                val formattedResult = if (number.absoluteValue < 1e-6) {
                    "0"
                } else {
                    val decimalFormat = DecimalFormat("0." + "#".repeat(maxDecimalDigits))
                    decimalFormat.format(number)
                }

                if (formattedResult.length > maxDigits) {
                    val scientificFormat = DecimalFormat("0." + "E0")
                    result = scientificFormat.format(number)
                } else {
                    result = formattedResult
                }
            }

            result
        } catch (e: Exception) {
            "Error"
        }
    }


    private fun handleModulo(input: String): String {
        val regex = Regex("""(-?\d+(\.\d+)?)%\((-?\d+(\.\d+)?)\)""")
        return regex.replace(input) {
            val dividend = it.groupValues[1].toDouble()
            val divisor = it.groupValues[3].toDouble()
            (dividend % divisor).toString()
        }
    }



    private fun handleScientificFunctions(input: String, functionName: String, operation: (Double) -> Double): String {
        val regex = Regex("""$functionName\(([^)]+)\)""")
        return regex.replace(input) {
            val value = it.groupValues[1].toDouble()
            val angleInRadians = Math.toRadians(value)
            operation.invoke(angleInRadians).toString()
        }
    }

    private fun handleScientificFunctions2(input: String, functionName: String, operation: (Double) -> Double): String {
        val regex = Regex("""$functionName\((-?\d+(\.\d+)?)\)""")
        return regex.replace(input) {
            val value = it.groupValues[1].toDouble()
            operation.invoke(value).toString()
        }
    }


    private fun handleSquareRoot(input: String): String {
        val regex = Regex("""√\(([^)]+)\)""")
        return regex.replace(input) {
            val value = it.groupValues[1].toDouble()
            sqrt(value).toString()
        }
    }


}