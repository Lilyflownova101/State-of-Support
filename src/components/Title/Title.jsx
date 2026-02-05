import styles from "./Title.module.css";
import confetti from "canvas-confetti";

export default function Title() {
  const handleLogoClick = () => {
    confetti({
      particleCount: 150,
      spread: 70,
      origin: { y: 0.3 },
      colors: ["#DAB6E1", "#9E67B2", "#5F2B70"],
    });

    
  }; 

  
  return (
    <div className={styles.titleContainer}>
      <img
        src="../../img/logo_transparent.png"
        className={styles.logo}
        alt="State of Support Logo"
        onClick={handleLogoClick}
        style={{ cursor: "pointer" }} 
      />
      <h1 className={styles.mainHeading}>Welcome to State of Support</h1>
    </div>
  );
}