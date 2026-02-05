import styles from "./QuickExitButton.module.css";

export default function QuickExitButton() {
    const handleExit = () => {window.location.replace("https://weather.com/"); };


    return (
        <button className= {styles.exitButton} onClick = {handleExit}>
                Leave Safely
        </button>

    ); 
}