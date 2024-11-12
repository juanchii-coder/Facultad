cont=0

while true; do
    if [ $(pregp apache) -eq 0 ]; then
        cont=$((cont + 1))
    fi

    if [ "$cont" -eq 10 ]; then
        echo "se encontro 10 veces el proceso corriendo"
        exit 50
    fi

    sleep 5

done