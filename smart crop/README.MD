# Smart Crop Recommendation System

##  Project Description

The **Smart Crop Recommendation System** is a Java-based console application that recommends a suitable crop based on soil and environmental conditions.

The system takes important agricultural parameters such as Nitrogen, Phosphorus, Potassium, Temperature, Humidity, Rainfall, and Soil pH as input. It compares these values with predefined suitable ranges for different crops and calculates a suitability score.

The crop with the highest suitability score is recommended to the user.


##  Student Details

- **Student Name:** Vedanshi Patidar
- **Registration No.:** 25BAI10630
- **Subject:** Programming in Java
- **Department:** B.Tech (AI/ML)


##  Objectives

- To develop a simple crop recommendation system using Java.
- To use soil and environmental parameters for crop selection.
- To implement Object-Oriented Programming concepts.
- To calculate a suitability score for different crops.
- To handle invalid user inputs using exception handling.


##  Features

- Accepts soil nutrient values.
- Accepts temperature and humidity.
- Accepts rainfall information.
- Accepts soil pH.
- Supports multiple crops.
- Calculates crop suitability scores.
- Recommends the crop with the highest score.
- Handles invalid input.
- Provides a simple console-based interface.



##  Crops Included

The current system contains predefined conditions for:

1. Rice
2. Wheat
3. Maize
4. Cotton
5. Sugarcane
6. Pulses


##  Input Parameters

The user provides the following values:

| Parameter | Description |
|---|---|
| Nitrogen (N) | Nitrogen level in soil |
| Phosphorus (P) | Phosphorus level in soil |
| Potassium (K) | Potassium level in soil |
| Temperature | Environmental temperature |
| Humidity | Environmental humidity |
| Rainfall | Rainfall level |
| Soil pH | Acidity/alkalinity of soil |


##  Suitability Score

The system calculates the score using predefined ranges for every crop.

| Parameter | Score |
|---|---:|
| Nitrogen | 15 |
| Phosphorus | 15 |
| Potassium | 15 |
| Temperature | 15 |
| Humidity | 10 |
| Rainfall | 15 |
| Soil pH | 15 |
| **Maximum Score** | **100%** |

If the entered value falls within the suitable range of a crop, the corresponding points are added.

The crop having the highest score is selected as the recommendation.



##  Working of the System

```text
User
  ↓
Enter Soil & Environmental Data
  ↓
Input Validation
  ↓
Create SoilData Object
  ↓
Compare Data with Crop Ranges
  ↓
Calculate Suitability Score
  ↓
Find Highest Score
  ↓
Recommend Crop
  ↓
Display Result
