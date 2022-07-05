# Redux-Currency-Android

[![Circle CI](https://circleci.com/gh/osmanowadim/Redux-Currency-Android.svg?style=shield)](https://circleci.com/gh/osmanowadim/Redux-Currency-Android)

Simple app that shows exchange rate relative to UAH, using data
from https://bank.gov.ua/NBUStatService/v1/statdirectory, structured according to the Redux pattern.

This app contains the implementation of network requests using Retrofit + Coroutine and parse XML as
response from server.

<p align="center">
  <img src="main_screen.jpg" width="350" alt="Screenshot_1">
</p>

<p align="center">
  <img src="additional_screen.jpg" width="350" alt="Screenshot_2">
</p>

<p align="center">
  <img src="additional_screen2.jpg" width="350" alt="Screenshot_3">
</p>

Added Storybook flow - to cover the project with UI tests and make it easy to show all UI states.

<p align="center">
  <img src="storybook_screen.jpg" width="350" alt="Screenshot_1">
</p>

<p align="center">
  <img src="storybook_loading_screen.jpg" width="350" alt="Screenshot_1">
</p>

<p align="center">
  <img src="storybook_error_screen.jpg" width="350" alt="Screenshot_1">
</p>

For launching Storybook flow - need to choose Build Variants -> storybook. This Build Variant will
open new entry point -> StorybookActivity.

Also added CI which run Unit tests and UI tests exactly in Storybook flow.
