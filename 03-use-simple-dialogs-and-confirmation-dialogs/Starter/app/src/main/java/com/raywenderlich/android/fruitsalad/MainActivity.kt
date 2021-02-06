/*
 * Copyright (c) 2020 Razeware LLC
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 * 
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.raywenderlich.android.fruitsalad

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class MainActivity : AppCompatActivity() {

  private val fruitItems
    get() = arrayOf(
        getString(R.string.fruit_banana),
        getString(R.string.fruit_orange),
        getString(R.string.fruit_lime))

  private val fruitList: String
    get() = getString(R.string.fruit_list, noOfBananas, noOfOranges, noOfLimes)

  private var noOfBananas: Int = DEFAULT_QUANTITY
  private var noOfOranges: Int = DEFAULT_QUANTITY
  private var noOfLimes: Int = DEFAULT_QUANTITY

  override fun onCreate(savedInstanceState: Bundle?) {
    // Switch to AppTheme for displaying the activity
    setTheme(R.style.AppTheme)
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    updateViews()
    setupClickListeners()
  }

  private fun updateViews() {
    text_banana_quantity.text = noOfBananas.toString()
    text_orange_quantity.text = noOfOranges.toString()
    text_lime_quantity.text = noOfLimes.toString()
  }

  private fun setupClickListeners() {
    card_mystery.setOnClickListener { loadSurpriseDialog() }
    button_add.setOnClickListener { showAddFruitDialog() }
    button_copy.setOnClickListener { saveToClipboard() }
    button_clear.setOnClickListener { showClearListConfirmationDialog() }
  }

  private fun showAddFruitDialog() {
    // TODO: show simple dialog containing fruit items
  }

  private fun showClearListConfirmationDialog() {
    // TODO: show alert dialog to confirm clear list action
  }

  private fun loadSurpriseDialog() {
    // TODO: show progress indicator
    // TODO: show dialog with custom view
  }

  private fun showSnackbar(selectedFruitItem: Int) {
    // TODO: show snackbar with undo action
  }

  private fun saveToClipboard() {
    val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    val clip = ClipData.newPlainText(getString(R.string.fruit_list_title), fruitList)
    clipboard.setPrimaryClip(clip)
    showToast()
  }

  private fun showToast() {
    // TODO: show toast confirmation
  }

  private fun updateFruitQuantity(selectedFruitItem: Int? = null, isIncrease: Boolean) {
    when (selectedFruitItem) {
      POSITION_BANANA -> if (isIncrease) noOfBananas++ else noOfBananas--
      POSITION_ORANGE -> if (isIncrease) noOfOranges++ else noOfOranges--
      POSITION_LIME -> if (isIncrease) noOfLimes++ else noOfLimes--
      else -> {
        noOfBananas = DEFAULT_QUANTITY
        noOfOranges = DEFAULT_QUANTITY
        noOfLimes = DEFAULT_QUANTITY
      }
    }
    updateViews()
  }

  companion object {
    private const val DEFAULT_QUANTITY = 0
    private const val POSITION_BANANA = 0
    private const val POSITION_ORANGE = 1
    private const val POSITION_LIME = 2
    private const val TAG_FRUIT_DIALOG = "fruitDialog"
    private const val DELAY = 2000L
  }
}
