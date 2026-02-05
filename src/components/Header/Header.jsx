import styles from "./Header.module.css";


export default function Header({title, description}) {
    return (

        <header className={styles.headerContainer}>
            <h1 className={styles.title}>{title}</h1>
            <div className={styles.divider}></div>
            <p className={styles.description}>{description}</p>
        </header>



    ); 
}