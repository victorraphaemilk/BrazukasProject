import React, { useState, useEffect } from 'react';
import api from '../services/api';

const Manager = () => {
    const [players, setPlayers] = useState([]);
    const [newPlayer, setNewPlayer] = useState({ name: '', number: 0, position: '' });
    const [removePlayerIdentifier, setRemovePlayerIdentifier] = useState('');
    const [removeByIdentifierType, setRemoveByIdentifierType] = useState('name');

    useEffect(() => {
        fetchPlayers();
    }, []);

    const fetchPlayers = async () => {
        try {
            const response = await api.get('/manager/players');
            setPlayers(response.data);
        } catch (error) {
            console.error('Error fetching players:', error);
        }
    };

    const addPlayer = async () => {
        try {
            await api.post('/manager/players', newPlayer);
            fetchPlayers();
        } catch (error) {
            console.error('Error adding player:', error);
        }
    };

    const removePlayer = async () => {
        try {
            if (removeByIdentifierType === 'name') {
                await api.delete(`/manager/players/name/${removePlayerIdentifier}`);
            } else {
                await api.delete(`/manager/players/number/${removePlayerIdentifier}`);
            }
            fetchPlayers();
        } catch (error) {
            console.error('Error removing player:', error);
        }
    };

    return (
        <div>
            <h1>Manager View</h1>
            <div>
                <h2>Players</h2>
                <ul>
                    {players.map((player) => (
                        <li key={player.codigo}>{player.nome} - {player.numero} - {player.posicao}</li>
                    ))}
                </ul>
            </div>
            <div>
                <h2>Add Player</h2>
                <input
                    type="text"
                    placeholder="Name"
                    onChange={(e) => setNewPlayer({ ...newPlayer, nome: e.target.value })}
                />
                <input
                    type="number"
                    placeholder="Number"
                    onChange={(e) => setNewPlayer({ ...newPlayer, numero: parseInt(e.target.value) })}
                />
                <input
                    type="text"
                    placeholder="Position"
                    onChange={(e) => setNewPlayer({ ...newPlayer, posicao: e.target.value })}
                />
                <button onClick={addPlayer}>Add</button>
            </div>
            <div>
                <h2>Remove Player</h2>
                <select onChange={(e) => setRemoveByIdentifierType(e.target.value)}>
                    <option value="name">Name</option>
                    <option value="number">Number</option>
                </select>
                <input
                    type="text"
                    placeholder={removeByIdentifierType === 'name' ? 'Name' : 'Number'}
                    onChange={(e) => setRemovePlayerIdentifier(e.target.value)}
                />
                <button onClick={removePlayer}>Remove</button>
            </div>
        </div>
    );
};

export default Manager;
