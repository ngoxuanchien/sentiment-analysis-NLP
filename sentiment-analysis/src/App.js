import "./App.css";
import { useEffect, useState } from "react";

function App() {
  const [inputText, setInputValue] = useState("");
  const [result, setResult] = useState("");

  const getColor = (type) => {
    console.log("color");
    switch (type) {
      case "veryPositive":
        return "#4caf50";
      case "positive":
        return "#8bc34a";
      case "neutral":
        return "#cddc39";
      case "negative":
        return "#ffeb3b";
      case "veryNegative":
        return "#f44336";
      default:
        return "#FFFFF";
    }
  };

  const getText = (type) => {
    switch (type) {
      case "veryPositive":
        return "very positive";
      case "positive":
        return "positive";
      case "neutral":
        return "neutral";
      case "negative":
        return "negative";
      case "veryNegative":
        return "very negative";
      default:
        return "";
    }
  };

  const getIcon = (type) => {
    console.log("getIcon is called with", type);
    switch (type) {
      case "Very positive":
        return "😀";
      case "Positive":
        return "🙂";
      case "Neutral":
        return "😐";
      case "Negative":
        return "🙁";
      case "Very negative":
        return "😞";
      default:
        return "😀🙂😐🙁😞";
    }
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        // console.log("fetching data from server");
        const response = await fetch(
          "http://localhost:8080/api/sentiment/" + inputText
        );
        const data = await response.json();
        console.log("data fetched from server", data);
        setResult(data);
      } catch (error) {
        console.error("Failed to fetch data from server", error);
      }
    };

    fetchData();
  }, [inputText]);

  return (
    <div className="App-header">
      <p className="icon">{getIcon(result.sentimentType)} </p>
      <input
        type="text"
        value={inputText}
        onChange={(e) => setInputValue(e.target.value)}
        placeholder="Enter text here"
      />
      <div className="sentiment-scores">
        {result?.sentimentClass &&
          Object.entries(result?.sentimentClass).map(([key, value]) => (
            <div className="sentiment-score">
              <div>
                <span className="sentiment-type">{getText(key)}</span>
              </div>
              <div className="sentiment-value-bars">
                <div
                  className="sentiment-value-bar"
                  style={{ width: `${value}%`, backgroundColor: getColor(key) }}
                ></div>
                <span>{value}%</span>
              </div>
            </div>
          ))}
      </div>
    </div>
  );
}

export default App;
