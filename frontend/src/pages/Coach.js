import React, { useState, useEffect } from 'react';
import api from '../services/api';

const Coach = () => {
    const [players, setPlayers] = useState([]);
    const [titularPlayers, setTitularPlayers] = useState([]);
    const [selectedPlayer, setSelectedPlayer] = useState('');
    const [selectedPlayerType, setSelectedPlayerType] = useState('name');

    useEffect(() => {
        fetchPlayers();
        fetchTitularPlayers();
    }, []);

    const fetchPlayers = async () => {
        try {
            const response = await api.get('/coach/players');
            setPlayers(response.data);
        } catch (error) {
            console.error('Error fetching players:', error);
        }
    };

    const fetchTitularPlayers = async () => {
        try {
            const response = await api.get('/coach/titular');
            setTitularPlayers(response.data);
        } catch (error) {
            console.error('Error fetching titular players:', error);
        }
    };

    const addTitularPlayer = async () => {
        try {
            if (selectedPlayerType === 'name') {
                await api.post(`/coach/titular/name/${selectedPlayer}`);
            } else {
                await api.post(`/coach/titular/number/${selectedPlayer}`);
            }
            fetchTitularPlayers();
        } catch (error) {
            console.error('Error adding titular player:', error);
        }
    };

    const removeTitularPlayer = async () => {
        try {
            if (selectedPlayerType === 'name') {
                await api.delete(`/coach/titular/name/${selectedPlayer}`);
            } else {
                await api.delete(`/coach/titular/number/${selectedPlayer}`);
            }
            fetchTitularPlayers();
        } catch (error) {
            console.error('Error removing titular player:', error);
        }
    };

    return (
        <div>
            <h1>Coach View</h1>
            <div>
                <h2>All Players</h2>
                <ul>
                    {players.map((player) => (
                        <li key={player.codigo}>{player.nome} - {player.numero} - {player.posicao}</li>
                    ))}
                </ul>
            </div>
            <div>
                <h2>Titular Players</h2>
                <ul>
                    {titularPlayers.map((player) => (
                        <li key={player.codigo}>{player.nome} - {player.numero} - {player.posicao}</li>
                    ))}
                </ul>
            </div>
            <div>
                <h2>Manage Titular Players</h2>
                <select onChange={(e) => setSelectedPlayerType(e.target.value)}>
                    <option value="name">Name</option>
                    <option value="number">Number</option>
                </select>
                <input
                    type="text"
                    placeholder={selectedPlayerType === 'name' ? 'Name' : 'Number'}
                    onChange={(e) => setSelectedPlayer(e.target.value)}
                />
                <button onClick={addTitularPlayer}>Add to Titular</button>
                <button onClick={removeTitularPlayer}>Remove from Titular</button>
            </div>
        </div>
    );
};

export default Coach;
