# MeasureDistance

<br>This is an Android Project which fetches Customer Information and filters those residing within 100 km.</br>
<br>The filtered result is displayed as a List (Recycler View) when the app is launched. Also, the sample output of the result is stored as output.txt file under [output](https://github.com/manasa-murali/MeasureDistance/blob/master/output/output.txt) directory</br>

<br> **Steps to install**</br>

This project can be opened in Android Studio
<br>
Use
```
git clone https://github.com/manasa-murali/MeasureDistance.git
```
in your terminal, and launch this project in Android Studio
<br>
<br>
The entry point to this project is [FilterFragment.kt](https://github.com/manasa-murali/MeasureDistance/blob/master/app/src/main/java/com/example/measuredistance/view/FilterFragment.kt)
<br>
<br> This code base follows MVVM architecture, hence, the View(FilterFragment) asks the ViewModel to perform filter operation through ```filterData()``` method in the view model.
<br>
The businuess logic or the computation is isolated and happens in the [ViewModel](https://github.com/manasa-murali/MeasureDistance/blob/master/app/src/main/java/com/example/measuredistance/viewmodel/DistanceViewModel.kt)
<br> The given customer data is fetched using **OkHttp Library** 
<br>
When the filtering is complete , the View listens for the changeset from the viewmodel and updates the UI.
<br>

## Running Tests<br>
[DistanceViewModelTest.kt](https://github.com/manasa-murali/MeasureDistance/blob/master/app/src/test/java/com/example/measuredistance/viewmodel/DistanceViewModelTest.kt) contains the tests for the business logic.
<br>1. After navigating to this file in Android Studio, you can click on the icon to the left side of the class name, and select `Run DistanceViewModelTest` or <br>
2. Go to src/test/java/com.example.measuredistance.viewmodel package in your Project View from Dropdown and right click on this package to select, `Run Tests in 'viewmodel'`
<br>




